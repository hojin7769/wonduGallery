package com.example.wondugallery.config;

import org.springframework.boot.Banner;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

/**
 * @author admin
 * @version 1.0
 * @project wondu-gallery
 * @package com.example.wondugallery.config
 * @date 2023-10-06
 * @explanation
 */
public class WonduGalleryBanner implements Banner {

    @Override
    public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
        out.println("""
                                
                       __       __                            __             ______             __  __                              \s
                      /  |  _  /  |                          /  |           /      \\           /  |/  |                             \s
                      $$ | / \\ $$ |  ______   _______    ____$$ | __    __ /$$$$$$  |  ______  $$ |$$ |  ______    ______   __    __\s
                      $$ |/$  \\$$ | /      \\ /       \\  /    $$ |/  |  /  |$$ | _$$/  /      \\ $$ |$$ | /      \\  /      \\ /  |  /  |
                      $$ /$$$  $$ |/$$$$$$  |$$$$$$$  |/$$$$$$$ |$$ |  $$ |$$ |/    | $$$$$$  |$$ |$$ |/$$$$$$  |/$$$$$$  |$$ |  $$ |
                      $$ $$/$$ $$ |$$ |  $$ |$$ |  $$ |$$ |  $$ |$$ |  $$ |$$ |$$$$ | /    $$ |$$ |$$ |$$    $$ |$$ |  $$/ $$ |  $$ |
                      $$$$/  $$$$ |$$ \\__$$ |$$ |  $$ |$$ \\__$$ |$$ \\__$$ |$$ \\__$$ |/$$$$$$$ |$$ |$$ |$$$$$$$$/ $$ |      $$ \\__$$ |
                      $$$/    $$$ |$$    $$/ $$ |  $$ |$$    $$ |$$    $$/ $$    $$/ $$    $$ |$$ |$$ |$$       |$$ |      $$    $$ |
                      $$/      $$/  $$$$$$/  $$/   $$/  $$$$$$$/  $$$$$$/   $$$$$$/   $$$$$$$/ $$/ $$/  $$$$$$$/ $$/        $$$$$$$ |
                                                                                                                           /  \\__$$ |
                                                                                                                           $$    $$/\s
                                                                                                                            $$$$$$/ \s
                                
                """);
    }
}
