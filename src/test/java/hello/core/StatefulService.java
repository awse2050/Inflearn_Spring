package hello.core;

public class StatefulService {

    //상태를 유지하는 필드
//    private int price;

    public int order (String name, int price) {
       return price; // 여기가 문제
    }

//    public int getPrice() {
//        return price;
//    }

}
