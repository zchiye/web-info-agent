package io.zchiye.web.info.agent.common.utils;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class OsUtils {

    private static final Logger logger = LoggerFactory.getLogger(OsUtils.class);

    public static String getFileContent(File file, String charset) {
        if (file == null || !file.exists() || !file.isFile()) {
            return null;
        }
        try {
            return FileUtils.readFileToString(file, charset);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

}
