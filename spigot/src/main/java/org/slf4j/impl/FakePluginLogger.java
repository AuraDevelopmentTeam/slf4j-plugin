package org.slf4j.impl;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;

/**
 * Fake plugin logger that tries to mimic the behavior of
 * https://hub.spigotmc.org/stash/projects/SPIGOT/repos/bukkit/browse/src/main/java/org/bukkit/plugin/PluginLogger.java
 * as close as possible.
 *
 * <p>In addition also caches its instances.
 *
 * @author Yannick Schinko
 */
public class FakePluginLogger extends Logger {
  private static final ConcurrentMap<String, FakePluginLogger> loggerMap =
      new ConcurrentHashMap<>();

  private final String loggerPrefix;
  private final ConsoleCommandSender consoleCommandSender;

  public static FakePluginLogger getLogger(String pluginName) {
    FakePluginLogger logger = loggerMap.get(pluginName);
    if (logger != null) return logger;

    // In case it has *just* been added
    FakePluginLogger newInstance = new FakePluginLogger(pluginName);
    FakePluginLogger oldInstance = loggerMap.putIfAbsent(pluginName, newInstance);
    return oldInstance == null ? newInstance : oldInstance;
  }

  protected FakePluginLogger(String pluginName) {
    super(pluginName, null);

    this.loggerPrefix = pluginName.isEmpty() ? "" : "[" + pluginName + "] ";
    consoleCommandSender = Bukkit.getConsoleSender();

    setLevel(Level.ALL);
  }

  @Override
  public void log(LogRecord logRecord) {
    consoleCommandSender.sendMessage(loggerPrefix + logRecord.getMessage());
  }
}
