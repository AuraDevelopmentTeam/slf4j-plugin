package org.slf4j.impl;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import net.md_5.bungee.api.ProxyServer;

/**
 * Fake plugin logger that tries to mimic the behavior of
 * https://github.com/SpigotMC/BungeeCord/blob/master/api/src/main/java/net/md_5/bungee/api/plugin/PluginLogger.java
 * as close as possible.
 *
 * <p>In additon also caches its instances.
 *
 * @author Yannick Schinko
 */
public class FakePluginLogger extends Logger {
  private static final ConcurrentMap<String, FakePluginLogger> loggerMap =
      new ConcurrentHashMap<>();

  private final String pluginName;

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

    this.pluginName = "[" + pluginName + "] ";

    setParent(ProxyServer.getInstance().getLogger());
  }

  @Override
  public void log(LogRecord logRecord) {
    logRecord.setMessage(pluginName + logRecord.getMessage());

    super.log(logRecord);
  }
}
