package com.tw.question2;

import java.io.File;
import java.io.FileFilter;

/**
 * @Author: tanwei
 * @Description:
 * @Date: Create in 15:39 2019/7/4
 */
public class MyFileFilter implements FileFilter {

    public boolean accept(File pathname) {
        return pathname.getName().endsWith(".java");
    }
}
