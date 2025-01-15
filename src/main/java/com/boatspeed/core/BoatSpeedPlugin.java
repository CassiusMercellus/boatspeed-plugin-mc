package com.boatspeed.core;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class BoatSpeedPlugin extends JavaPlugin implements Listener {

    private double speedMultiplier;
    private double playerBoostFactor;
    private double minVelocity;

    @Override
    public void onEnable() {
        getLogger().info("BoatSpeedPlugin enabled!");
        getServer().getPluginManager().registerEvents(this, this);
        saveDefaultConfig(); // Save the default config if not already present
        loadConfigValues(); // Load configurable values
    }

    @Override
    public void onDisable() {
        getLogger().info("BoatSpeedPlugin disabled!");
    }

    private void loadConfigValues() {
        FileConfiguration config = getConfig();
        speedMultiplier = config.getDouble("speed-multiplier", 1.0); // Default to 1.0
        playerBoostFactor = config.getDouble("player-boost-factor", 1.1); // Default to 1.1
        minVelocity = config.getDouble("min-velocity", 1.5); // Default to 0.1

        getLogger().info("Config values loaded:");
        getLogger().info("Speed Multiplier: " + speedMultiplier);
        getLogger().info("Player Boost Factor: " + playerBoostFactor);
        getLogger().info("Minimum Velocity: " + minVelocity);
    }

    @EventHandler
    public void onBoatMove(VehicleMoveEvent event) {
        if (!(event.getVehicle() instanceof Boat)) {
            return; // Ignore non-boat vehicles
        }

        Boat boat = (Boat) event.getVehicle();

        // Check if the boat is in water
        Material blockBelow = boat.getLocation().subtract(0, 1, 0).getBlock().getType();
        if (blockBelow != Material.WATER) {
            return;
        }

        Vector currentVelocity = boat.getVelocity();


        // Handle case when boat is stationary
        if (currentVelocity.length() == 0) {
            Vector direction = boat.getLocation().getDirection().normalize();
            Vector minimumVelocity = direction.multiply(minVelocity);
            boat.setVelocity(minimumVelocity);

            return;
        }

        // Adjust speed differently based on passenger presence
        if (!boat.getPassengers().isEmpty() && boat.getPassengers().get(0) instanceof Player) {
            Vector boostedVelocity = currentVelocity.multiply(speedMultiplier * playerBoostFactor);
            boat.setVelocity(boostedVelocity);

        } else {
            Vector boostedVelocity = currentVelocity.multiply(speedMultiplier);
            boat.setVelocity(boostedVelocity);

        }
    }

    public void reloadPluginConfig() {
        reloadConfig(); // Reloads the config from disk
        loadConfigValues(); // Re-apply the loaded values

    }
}