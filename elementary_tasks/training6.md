# conditional_branch_switch

## 6-1

月を表す数値を入力し、入力された月から年末までの祝日を表示する

```java
System.out.println("月を数字で入力してください");

    Scanner scanner = new Scanner(System.in);

    int inputtedValue = scanner.nextInt();
    int endIndex = 15;
    int startIndex = 0;
    switch(inputtedValue){
      case 7:
        startIndex = 8;
        break;
      case 10:
        startIndex = 11;
        break;
      case 11:
        startIndex = 12;
        break;
      case 12:
        startIndex = 14;
        break;
      default:
        startIndex = inputtedValue - 1;
    }
    scanner.close();

    String[] annualHolidays = { "元日", "成人の日", "建国記念日", "春分の日", "昭和の日", "憲法記念日", "みどりの日", "こどもの日", "海の日", "敬老の日", "秋分の日",
        "体育の日", "文化の日", "勤労感謝の日", "天皇誕生日" };

    String[] monthHolidays = Arrays.copyOfRange(annualHolidays, startIndex, endIndex);
    String holidays =  Arrays.toString(monthHolidays);

    switch (inputtedValue) {
      case 1:
        System.out.println("1月~12月の祝日は" + holidays + "です");
        break;
      case 2:
        System.out.println("2月~12月の祝日は" + holidays + "です");
        break;
      case 3:
        System.out.println("3月~12月の祝日は" + holidays + "です");
        break;
      case 4:
        System.out.println("4月~12月の祝日は" + holidays + "です");
        break;
      case 5:
        System.out.println("5月~12月の祝日は" + holidays + "です");
        break;
      case 7:
        System.out.println("7月~12月の祝日は" + holidays + "です");
        break;
      case 9:
        System.out.println("9月~12月の祝日は" + holidays + "です");
        break;
      case 10:
        System.out.println("10月~12月の祝日は" + holidays + "です");
        break;
      case 11:
        System.out.println("11月~12月の祝日は" + holidays + "です");
        break;
      case 12:
        System.out.println("12月の祝日は" + holidays + "です");
    }
```

## 6-2

月を表す数値を入力し、その月の日数を表示する

```java
System.out.println("月を数字で入力してください");

    Scanner scanner = new Scanner(System.in);
    int inputtedValue = scanner.nextInt();

    switch (inputtedValue) {
      case 1:
        System.out.println("1月は31日です");
        break;
      case 2:
        System.out.println("2月は28日です");
        break;
      case 3:
        System.out.println("3月は31日です");
        break;
      case 4:
        System.out.println("4月は30日です");
        break;
      case 5:
        System.out.println("5月は31日です");
        break;
      case 6:
        System.out.println("6月は30日です");
        break;
      case 7:
        System.out.println("7月は31日です");
        break;
      case 8:
        System.out.println("8月は31日です");
        break;
      case 9:
        System.out.println("9月は30日です");
        break;
      case 10:
        System.out.println("10月は31日です");
        break;
      case 11:
        System.out.println("11月は30日です");
        break;
      case 12:
        System.out.println("12月は31日です");
        break;
      default:
        System.out.println("入力が間違っています");
    }
```
