package org.apache.maven.myMaven;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App 
{
    public static void main( String[] args )
    {
       
    }
    static boolean isValid(String str)
	{
		Pattern pattern = Pattern.compile ("[^\\[a-z0-9\\]]");
		Matcher matcher = pattern.matcher (str);
		
		if (matcher.find()) return false;
		else return true;
	}
	
	static String unpack(String input)
	{
		Pattern squareBrackets = Pattern.compile ("\\d+\\[\\w+\\]"); //задаем образец: число[число-буквенное содержимое]
		if (!input.contains("[")) return input; //терминальное условие рекурсии
		else 
		{
			Matcher matcher = squareBrackets.matcher (input);
			matcher.find(); //находим совпадениe
			//разбиваем совпадение на кол-во повторений (parts[0]) и повторяемый элемент (parts[1])
			String[] parts = matcher.group().split("\\[");
			String content = parts[1].replace("]", "");
			//"раскрытие" скобки
			int n = Integer.valueOf(parts[0]);
			String change = "";
			for (int i =0;i<n;i++)
			{
				change += content;
			}
			//ищем следующие совпадения 
			return unpack(input.replace(matcher.group(),change));     	
		}
			
	}
}
