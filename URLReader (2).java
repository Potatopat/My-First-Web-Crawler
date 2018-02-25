import java.net.*;
import java.io.*;

public class URLReader
{
    public static void main(String[] args) throws Exception
    {
        System.out.print("\f");
        
        URL url = new URL("http://www.jacobsxc.com/");
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        
        String[] line = new String[1];
        String[] temp = new String[1];
        String inputLine;
        int i = 0;
        
        while ((inputLine = in.readLine()) != null)
        {
            if (inputLine.contains("<li>") || inputLine.contains("</li>") || inputLine.contains("<li id=\"text\">"))
            {
                inputLine = inputLine.replace("<li>", "");
                inputLine = inputLine.replace("</li>", "");
                inputLine = inputLine.replace("<li id=\"text\">", "");
            }
            if (inputLine.contains("<a href="))
            {
                inputLine = inputLine.replace("<a href=", "");
            }
            if (inputLine.contains("><span>") || inputLine.contains("</a>"))
            {
                inputLine = inputLine.replace("><span>", " ");
                inputLine = inputLine.replace("</span></a>", "");
                inputLine = inputLine.replace("</a>", "");
            }
            if (inputLine.contains("<td>") || inputLine.contains("</td>"))
            {
                inputLine = inputLine.replace("<td>", "\t");
                inputLine = inputLine.replace("</td>", "");
            }
            if (inputLine.contains("<tr>") || inputLine.contains("</tr>"))
            {
                inputLine = inputLine.replace("<tr>", "\n");
                inputLine = inputLine.replace("</tr>", "");
            }
            if (inputLine.contains("<th>") || inputLine.contains("</th>"))
            {
                inputLine = inputLine.replace("<th>", "");
                inputLine = inputLine.replace("</th>", "");
            }
            if (inputLine.contains("PLEASE REMOVE"))
            {
                inputLine = "";
            }
            if (inputLine.contains("<html>") || inputLine.contains("</html>"))
            {
                inputLine = inputLine.replace("<html>", "");
                inputLine = inputLine.replace("</html>", "");
            }
            if (inputLine.contains("<head>") || inputLine.contains("</head>"))
            {
                inputLine = inputLine.replace("<head>", "");
                inputLine = inputLine.replace("</head>", "");
            }
            if (inputLine.contains("p>") || inputLine.contains("</p>"))
            {
                inputLine = inputLine.replace("<p>", "");
                inputLine = inputLine.replace("</p>", "");
            }
            if (inputLine.contains("<br>"))
            {
                inputLine = inputLine.replace("<br>", "\n");
            }
            if (inputLine.contains("</table>"))
            {
                inputLine = inputLine.replace("</table>", "");
            }
            if (inputLine.contains("<title>") || inputLine.contains("</title>"))
            {
                inputLine = inputLine.replace("<title>", "");
                inputLine = inputLine.replace("</title>", "");
            }
            if (inputLine.contains("<body TEXT"))
            {
                inputLine = "<body TEXT>";
            }
            if (inputLine.contains("</ul>"))
            {
                inputLine = inputLine.replace("</ul>", "");
            }
            if (inputLine.contains("<table "))
            {
                inputLine = "";
            }
            if (inputLine.contains("<div ") || inputLine.contains("</div"))
            {
                inputLine = inputLine.replace("<div ", "");
                inputLine = inputLine.replace(">", "");
                inputLine = inputLine.replace("</div", "");
            }
            /*if (inputLine.contains("<") || inputLine.contains(">") || inputLine.contains("</"))
            {
                inputLine = inputLine.replace("<", "");
                inputLine = inputLine.replace(">", "");
                inputLine = inputLine.replace("</", "");
            }*/
            
            System.out.println(inputLine);
            line[i] = inputLine;
            i++;
            temp = line;
            line = new String[line.length + 1];
            for (int a = 0; a < temp.length; a++)
            {
                line[a] = temp[a];
            }
            temp = new String[temp.length + 1];
        }
        
        in.close();
    }
}