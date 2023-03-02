import java.util.Date;
import java.util.Scanner;

/**
 * Main
 */
public class Main
{
    public static Scanner sc;

    public static void main(String[] args)
    {
        try
        {
            sc = new Scanner(System.in);
            FamilyTree familyTree = CreateFamilyTree();
            System.out.println("Генеалогическое древо состоит из %d человекЖ\n"                           +
                               " Введите ID человека (цифра от 1 до %d) для просмотра информации о нем\n" +
                               " Введите 0 для просмотра информации обо всех\n"                           +
                               " Enter - выход");
            while(true)
            {
                String input = sc.nextLine();
                int num = Integer.parseInt(input) - 1;
                if(num < 0)
                {
                    System.out.println(familyTree);
                }
                else if(num >= familyTree.Total())
                {
                    System.out.println("Неверный ID");
                }
                else
                {
                    FamilyMemeber memeber = familyTree.GetMemeberById(num);
                    System.out.println(memeber);
                }
            }
        }
        catch(Exception e)
        {
            System.out.printf("Ошибка: %s", e.getMessage());
        }
        finally
        {
            if(sc != null)
                sc.close();
        }
    }

    private static FamilyTree CreateFamilyTree()
    {
        var familyTree = new FamilyTree("Лысенко");
        var member = familyTree.AddChild("Николай", "мужской", date(5, 2, 1940));
        member.Spouse(new Human("Светлана Петрова", "женский", date(20, 10, 1945)));
        member = familyTree.AddChild("Роман", "мужской", date(4, 7, 1965), member.Id());
        member.Spouse(new Human("Мария Федорова", "женский", date(6, 3, 1972)));
        member = familyTree.AddChild("Иван", "мужской", date(14, 8, 1995), member.Id());
        member.Spouse(new Human("Анна Владимирова", "женский", date(26, 6, 1999)));
        familyTree.AddChild("Ольга", "женский", date(30, 9, 2020), member.Id());
        return familyTree;
    }

    private static Date date(int day, int month, int year)
    {
        return new Date(year, month, day);
    }
}