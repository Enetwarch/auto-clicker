# Auto Clicker

This is a basic personal autoclicker I made in Java that opens in the CLI. Once initialized, the program can take in hotkey inputs everywhere in the screen through a hook. This is done by implementing the [jnativehook library](https://github.com/kwhat/jnativehook/tree/2.2), specifically the global key listener and other related modules.

### Controls

* ***F9***: Toggle autoclicker on or off.
* ***F10***: Terminates the program.

### Warning

The current version of the autoclicker is designed to work on X Window Systems (X11). Because of this, it might not work properly on other environments.