
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {


    private String poem = "у лукоморья дуб зелёный;златая цепь на дубе том:" +
            "и днём и ночью кот учёныйвсё ходит по цепи кругом;" +
            "идёт направо — песнь заводит,налево — сказку говорит." +
            "там чудеса: там леший бродит,русалка на ветвях сидит;" +
            "там на неведомых дорожкахследы невиданных зверей;" +
            "избушка там на курьих ножкахстоит без окон, без дверей;" +
            "там лес и дол видений полны;" +
            "там о заре прихлынут волнына брег песчаный и пустой,и тридцать витязей прекрасных" +
            "чредой из вод выходят ясных," +
            "и с ними дядька их морской;" +
            "там королевич мимоходом" +
            "пленяет грозного царя;" +
            "там в облаках перед народом" +
            "через леса, через моря" +
            "колдун несёт богатыря;" +
            "в темнице там царевна тужит," +
            "а бурый волк ей верно служит;" +
            "там ступа с бабою ягой" +
            "идёт, бредёт сама собой," +
            "там царь кащей над златом чахнет;" +
            "там русский дух… там русью пахнет!" +
            "и там я был, и мёд я пил;у моря видел дуб зелёный;" +
            "под ним сидел, и кот учёныйсвои мне сказки говорил.";

    private int numberOfCharacters; // число символов в строке
    private int numberOfWords; // число слов в строке
    private int numberOfCharacterL; // число букв "л" в строке
    private boolean hasWordsFiveLetters; // наличие слов состоящих из 5 букв
    private String wordsStartsWithA; // строка из всех слов начинающихся на букву "а"

    // создание дополнительных полей для вывода на экран полученных значений
    private TextView infoApp; // поле вывода информации анализа строки

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberOfCharacters = countCharacters(poem);
        numberOfWords = countWords(poem);
        numberOfCharacterL = countCharacterL(poem);
        hasWordsFiveLetters = hasWordsFiveLetters(poem);
        wordsStartsWithA = getWordsStartsWithA(poem);

        // привязка поля к разметке по id
        infoApp = findViewById(R.id.infoApp);

        // вывод информации на экран смартфона
        infoApp.setText("число символов в строке " + numberOfCharacters + "\n"
                + "число слов в строке " + numberOfWords + "\n"
                + "число букв \"л\" в строке " + numberOfCharacterL + "\n"
                + "наличие слов \"5 букв\" " + hasWordsFiveLetters + "\n"
                + "строка из слов начинающихся на букву \"а\" " + wordsStartsWithA);
    }
    private int countWords(String stringPoem) {
        String[] words = stringPoem.split("\\s+");

        return words.length; // return the target string with leading and trailing spaces removed
    }
    // модуль определения количества символов в строке
    private int numberOfCharacters(String StringPoem) {
        return StringPoem.length();
    }

    // модуль подсчета числа символов в строке
    private int countCharacters(String stringPoem) {
        return stringPoem.length();
    }

    /// модуль подсчета числа букв "л" в строке
    private int countCharacterL(String stringPoem) {
        String[] chars = stringPoem.split("");
        int count = 0;
        for (String c : chars) {
            if (c.equals("л") || c.equals("Л")) {
                count++;
            }
        }
        return count;
    }

    // модуль определения наличия в строке слова "5 букв"
    private boolean hasWordsFiveLetters(String stringPoem) {
        String[] words = stringPoem.split("\\s+");
        for (String word : words) {
            if (word.length() == 5) {
                return true;
            }
        }

        return false;
    }

    // модуль компоновки строки из слов на букву "а" строки задачи
    private String getWordsStartsWithA(String str) {
        String[] words = str.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (word.startsWith("а") || word.startsWith("А")) {
                sb.append(word).append(" ");
            }
        }
        return sb.toString();
    }
}