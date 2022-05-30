package map;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.Scanner;

public class Display {
  public static void main(String[] args) throws IOException {

    // csv読み込み
    Csv csvFile = new Csv("C:\\Users\\t_takayama\\Documents\\schoo\\java_elementary\\map\\a.csv");
    Path csvReadData = csvFile.read();

    // dataをMapに変換
    ConvertMap map = new ConvertMap();
    Map<String, Map<String, Map<String, String>>> prefectures = map.prefecturesCsvToMap(csvReadData);

    String key;
    do {
      System.out.println("都道府県名を入力(終了する場合は空入力):");
      Scanner sc = new Scanner(System.in);
      key = sc.nextLine();

      if (key.isEmpty()) {
        System.out.println("入力を終了します");
        sc.close();
      }

      if (prefectures.containsKey(key)) {
        for(String city : prefectures.get(key).keySet() ){
          System.out.println(city + "=" + prefectures.get(key).get(city));
        }
      }

    } while (key.isEmpty() == false);

  }

  // class Prefecture{
  //   private String preName;
  //   private List<Municipality> municipalities;

  //   public Prefecture(String preName){
  //     Objects.requireNonNull(preName, "都道府県名は必須入力です");
  //     this.preName = preName;
  //     this.municipalities = new ArrayList<>();
  //   }
  // }

  // class Municipality{
  //   private String muniName;
  //   private String population;
  //   private String isCapital;

  //   public Municipality(String muniName, String population, String isCapital){
  //     this.muniName = muniName;
  //     this.population = population;
  //     this.isCapital = isCapital;
  //   }

  //   @Override
  //   public String toString(){
  //     return this.muniName + "={人口=" + this.population + ",都道府県庁所在地=" + this.isCapital + "}";
  //   }
  // }
}
