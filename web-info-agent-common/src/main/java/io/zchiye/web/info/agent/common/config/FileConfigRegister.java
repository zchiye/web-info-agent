package io.zchiye.web.info.agent.common.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.function.Consumer;

@Slf4j
public class FileConfigRegister {

    private File rootPathFile;
    private FileAlterationMonitor monitor;
    private FileAlterationObserver observer;

    public FileConfigRegister(long intervalMillis, String rootPath) {
        rootPathFile = new File(rootPath);
        monitor = new FileAlterationMonitor(intervalMillis);
        observer = new FileAlterationObserver(new File(rootPath));
        monitor.addObserver(observer);
        try {
            monitor.start();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    public void register(String path, Consumer<String> consumer) {
        if (StringUtils.isBlank(path) || consumer == null) {
            return;
        }
        File filePath = new File(rootPathFile, path);
        observer.addListener(new FileConfigListener(filePath.getPath(), consumer));
    }
}
