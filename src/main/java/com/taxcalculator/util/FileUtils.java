package com.taxcalculator.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import org.apache.commons.io.IOUtils;

public class FileUtils {

  @NotNull
  public static String readFileDataFromPath(@NotNull String resourcePath) throws IOException {
    return IOUtils.toString(
        Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResourceAsStream(resourcePath)),
        StandardCharsets.UTF_8
    );
  }
}
