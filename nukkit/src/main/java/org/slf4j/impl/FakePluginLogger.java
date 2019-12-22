package org.slf4j.impl;

import cn.nukkit.Server;
import cn.nukkit.utils.LogLevel;
import cn.nukkit.utils.Logger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Fake plugin logger that tries to mimic the behavior of
 * https://github.com/SpigotMC/BungeeCord/blob/master/api/src/main/java/net/md_5/bungee/api/plugin/PluginLogger.java
 * as close as possible.
 *
 * <p>In addition also caches its instances.
 *
 * @author Yannick Schinko
 */
public class FakePluginLogger implements Logger {
  private static final ConcurrentMap<String, FakePluginLogger> loggerMap =
      new ConcurrentHashMap<>();

  private final String loggerPrefix;

  public static FakePluginLogger getLogger(String pluginName) {
    FakePluginLogger logger = loggerMap.get(pluginName);
    if (logger != null) return logger;

    // In case it has *just* been added
    FakePluginLogger newInstance = new FakePluginLogger(pluginName);
    FakePluginLogger oldInstance = loggerMap.putIfAbsent(pluginName, newInstance);
    return oldInstance == null ? newInstance : oldInstance;
  }

  protected FakePluginLogger(String pluginName) {
    loggerPrefix = pluginName.isEmpty() ? "" : "[" + pluginName + "] ";
  }

  @Override
  public void emergency(String message) {
    log(LogLevel.EMERGENCY, message);
  }

  @Override
  public void alert(String message) {
    log(LogLevel.ALERT, message);
  }

  @Override
  public void critical(String message) {
    log(LogLevel.CRITICAL, message);
  }

  @Override
  public void error(String message) {
    log(LogLevel.ERROR, message);
  }

  @Override
  public void warning(String message) {
    log(LogLevel.WARNING, message);
  }

  @Override
  public void notice(String message) {
    log(LogLevel.NOTICE, message);
  }

  @Override
  public void info(String message) {
    log(LogLevel.INFO, message);
  }

  @Override
  public void debug(String message) {
    log(LogLevel.DEBUG, message);
  }

  @Override
  public void log(LogLevel level, String message) {
    Server.getInstance().getLogger().log(level, loggerPrefix + message);
  }

  @Override
  public void emergency(String message, Throwable t) {
    log(LogLevel.EMERGENCY, message, t);
  }

  @Override
  public void alert(String message, Throwable t) {
    log(LogLevel.ALERT, message, t);
  }

  @Override
  public void critical(String message, Throwable t) {
    log(LogLevel.CRITICAL, message, t);
  }

  @Override
  public void error(String message, Throwable t) {
    log(LogLevel.ERROR, message, t);
  }

  @Override
  public void warning(String message, Throwable t) {
    log(LogLevel.WARNING, message, t);
  }

  @Override
  public void notice(String message, Throwable t) {
    log(LogLevel.NOTICE, message, t);
  }

  @Override
  public void info(String message, Throwable t) {
    log(LogLevel.INFO, message, t);
  }

  @Override
  public void debug(String message, Throwable t) {
    log(LogLevel.DEBUG, message, t);
  }

  @Override
  public void log(LogLevel level, String message, Throwable t) {
    Server.getInstance().getLogger().log(level, loggerPrefix + message, t);
  }
}
