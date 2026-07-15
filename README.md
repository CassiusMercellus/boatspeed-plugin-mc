# BoatSpeed

A lightweight Minecraft plugin that makes boats travel significantly faster by boosting their movement while they're on water.

> **Compatible with:** Paper, Spigot, and Bukkit (tested on Minecraft **1.21.x**)

---

## Overview

Minecraft's Bukkit API does not expose a configurable boat speed value, making it impossible for plugins to directly increase boat speed.

**BoatSpeed** works around this limitation by continuously boosting the boat's movement as it travels across water, creating the effect of a much faster boat without requiring any client-side modifications.

The result is a substantial increase in travel speed while keeping usage completely automatic.

---

## Features

* Faster boat travel
* Works automatically when a player enters a boat
* Configurable speed values
* Lightweight with no commands required
* Supports all vanilla boat types
* Works in all worlds
* Compatible with Paper, Spigot, and Bukkit

---

## Installation

1. Download the plugin JAR.
2. Place it into your server's `plugins` folder.
3. Start or restart your server.
4. Edit the generated `config.yml` if you want to customize the speed.
5. Restart or reload the plugin after making configuration changes.

That's it—players will automatically receive faster boats.

---

## Configuration

The plugin generates a `config.yml` with the following settings:

```yaml
speed-multiplier: 1.0
player-boost-factor: 1.1
min-velocity: 1.5
```

### Options

| Option                | Description                                                                 |
| --------------------- | --------------------------------------------------------------------------- |
| `speed-multiplier`    | Base movement multiplier applied to boats.                                  |
| `player-boost-factor` | Additional multiplier applied when the boat has a player riding it.         |
| `min-velocity`        | Minimum velocity applied to help boats begin moving when nearly stationary. |

---

## How It Works

Due to limitations in the Bukkit API, plugins cannot directly modify a boat's internal movement speed.

Instead, BoatSpeed continuously boosts the boat's movement while it is travelling on water. This creates the appearance of much faster boats while remaining fully server-side.

Because this is a workaround rather than a true speed modification, boat movement may occasionally feel less smooth than vanilla movement, especially at very high speed multipliers.

---

## Known Limitations

This plugin uses the best method currently available through the Bukkit API.

As a result:

* Boat movement may feel slightly less smooth than vanilla.
* Very high speed settings can make boats harder to control.
* The plugin cannot directly modify Minecraft's internal boat speed because the API does not expose that functionality.

These limitations are inherent to the Bukkit API rather than the plugin itself.

---

## Compatibility

**Supported**

* Paper
* Spigot
* Bukkit

**Minecraft Version**

* Tested on **1.21.x**

Purpur, Folia, and other server software have not been tested.

---

## Commands

None.

The plugin works automatically.

---

## Permissions

None.

Every player can benefit from faster boats without any additional setup.

---

## Performance

BoatSpeed only performs simple movement calculations for active boats and is designed to be lightweight with minimal performance impact.

---

## Support

If you encounter any bugs or have feature requests, please open an issue on the project's repository.
