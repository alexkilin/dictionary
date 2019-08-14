package vacabulary;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int key;
        dictionary MyDictionary = new dictionary();
        while (true) {
            do{
            System.out.println("Что желаете делать?(1)-ввод новых слов;" +
                    "(2)-перевод с русского на  английский ; (3)- перевод с английского на русский");
            key = sc.nextInt();}
            while (!((key==1)||(key==2)||(key==3)));
            switch (key){
                case 1: MyDictionary.AddWord(); MyDictionary.saveDictionary();
                        break;
                case 2: MyDictionary.AskEnglishWord(MyDictionary.FindEngWordForLearning(MyDictionary.dictionaryList));
                        break;
                case 3: MyDictionary.AskRussianWord(MyDictionary.FindEngWordForLearning(MyDictionary.dictionaryList));
                        break;
            }




        }
    }
}
