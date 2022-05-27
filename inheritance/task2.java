package inheritance;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 以下２つのクラスから共通する部分を抜き出し、親クラス FileReaderBase を作成
// またそれを継承して利用するかたちへ、２つのクラスを修正

// class CSVReader {
//   final String fileSeparator = ",";

//   public List<List<String>> readAllLines(Path path, Charset cs) throws IOException {
//     List<String> lines = Files.readAllLines(path, cs);
//     return convert(lines);
//   }

//   public List<List<String>> convert(List<String> lines) {
//     List<List<String>> resultList = new ArrayList<>();
//     for (String line : lines) {
//       String[] array = line.split(this.fileSeparator);
//       resultList.add(Arrays.asList(array));
//     }

//     return resultList;
//   }
// }

// class TSVReader {
//   final String fileSeparator = "\t";

//   public List<List<String>> readAllLines(Path path, Charset cs) throws IOException {
//     List<String> lines = Files.readAllLines(path, cs);
//     return convert(lines);
//   }

//   public List<List<String>> convert(List<String> lines) {
//     List<List<String>> resultList = new ArrayList<>();
//     for (String line : lines) {
//       String[] array = line.split(this.fileSeparator);
//       resultList.add(Arrays.asList(array));
//     }

//     return resultList;
//   }
// }

public class task2 {

  public class FileReaderBase {
    private String fileSeparator;

    public FileReaderBase() {
    };

    public void setFileSeparator(String fileSeparator) {
      this.fileSeparator = fileSeparator;
    };

    public List<List<String>> readAllLines(Path path, Charset cs) throws IOException {
      List<String> lines = Files.readAllLines(path, cs);
      return convert(lines);
    };

    public List<List<String>> convert(List<String> lines) {
      List<List<String>> resultList = new ArrayList<>();
      for (String line : lines) {
        String[] array = line.split(this.fileSeparator);
        resultList.add(Arrays.asList(array));
      }

      return resultList;
    }
  }

  public class CSVReader extends FileReaderBase {
    String fileSeparator = ",";

    public CSVReader(String fileSeparator) {
      super.setFileSeparator(fileSeparator);
    }
  }

  public class TSVReader extends FileReaderBase {
    String fileSeparator = "\t";

    public TSVReader(String fileSeparator) {
      super.setFileSeparator(fileSeparator);
    }
  }
}
