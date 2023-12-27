package io.zchiye.web.info.agent.common.config;

import io.zchiye.web.info.agent.common.utils.JsonUtils;
import io.zchiye.web.info.agent.common.utils.OsUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;

import java.io.File;
import java.util.function.Consumer;

@Slf4j
public class FileConfigListener extends FileAlterationListenerAdaptor {

    private static final String DEFAULT_CHARSET = "UTF-8";

    private String path;
    private File file;
    private String charset;
    private Consumer<String> consumer;

    FileConfigListener(String path, Consumer<String> consumer) {
        this.path = path;
        this.file = new File(path);
        this.charset = DEFAULT_CHARSET;
        this.consumer = consumer;
        onFileCreate(file);
    }

    @Override
    public void onFileCreate(final File file) {
        log.info("FileConfigListener onFileCreate path = {}, file = {}", path, JsonUtils.toJson(file));
        loadFile(file);
    }

    @Override
    public void onFileChange(final File file) {
        log.info("FileConfigListener onFileChange path = {}, file = {}", path, JsonUtils.toJson(file));
        if (!this.file.equals(file)) {
            return;
        }
        loadFile(file);
    }

    private void loadFile(File file) {
        consumer.accept(OsUtils.getFileContent(file, charset));
    }

}
