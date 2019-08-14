package vacabulary;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class dictionary {
    static Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    ArrayList<word> dictionaryList = new ArrayList<>();

    public void AddWord (){ //метод добавления слова в Основной словарь
        String newWordEng;
        String newWordRu;
        System.out.println("Введите новое слово как оно пишется на английском языке латинскими буквами: ");
        newWordEng = sc.nextLine();

        System.out.println("Введите новое слово как оно пишется на русском языке: ");
        newWordRu = sc.nextLine();
        word newWord = new word();
        newWord.engMean=newWordEng;
        newWord.ruMean=newWordRu;
        newWord.EnLevel=3;
        newWord.RuLevel=3;
        dictionaryList.add(newWord);
        System.out.println("В словарь добавлено слово "+newWordEng +" "+newWordRu);
        System.out.println("Состав словаря: ");
        printDictionary();

    }

    public void printDictionary(){ //печать всего словаря
        for (int i = 0; i <dictionaryList.size(); i++) {
            System.out.println(dictionaryList.get(i).engMean+" "+ dictionaryList.get(i).ruMean);
        }
    }
    public void AskEnglishWord (word a) {
        String engV;
        System.out.println("Как пишется на английском "+ a.ruMean+"?");
        engV = sc.nextLine();
        if (a.engMean.equals(engV))
        {System.out.println("Верно!");
        a.EnLevel=a.EnLevel+1;
            System.out.println("Уровень знания английского значения этого слова "+a.EnLevel);}
    }
    public void AskRussianWord (word a) {
        String ruV;
        System.out.println("Что означает на русском языке слово  "+ a.engMean+"?");
        ruV = sc.nextLine();
        if (a.ruMean.equals(ruV))
        {System.out.println("Верно!");
        a.RuLevel=a.RuLevel+1;
            System.out.println("Уровень знания английского значения этого слова "+a.RuLevel);}
    }

    public word FindEngWordForLearning (ArrayList<word> a){
        int w=0;
        do {int index=(int) (Math.random()*(a.size()));
        w=+1;
        if (a.get(index).EnLevel<=5) return a.get(index);}
        while (w<=10);
        return a.get(((int) (Math.random()*(a.size()))));
    }
    public word FindRuWordForLearning (ArrayList<word> a){
        int w=0;
        do {int index=(int) (Math.random()*(a.size()));
        w=+1;
        if (a.get(index).RuLevel<=5) return a.get(index);}
        while (w<=10);
        return a.get(((int) (Math.random()*(a.size()))));
    }
    public void saveDictionary () {
        try {
            FileOutputStream fileOut = new FileOutputStream("dictionary.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(dictionaryList);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /tmp/employee.ser");
        }catch(IOException i) {
            i.printStackTrace();
        }
    }
    public void LoadDictionary () {

    }
}
