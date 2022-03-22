package techgeeknext.util;

import java.nio.file.Path;
import java.nio.file.Paths;

public final class FileUtil {

  private FileUtil() {
    // restrict instantiation
  }

  public static final String folderPath =  "resource//";
  public static final String folderEncPath =  "enc-files//";
  public static final Path filePath = Paths.get(folderPath);

}

