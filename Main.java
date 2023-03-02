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
            while(true)
            {
                System.out.println("Генеалогическое древо состоит из %d человекЖ\n"                           +
                                   " Введите ID человека (цифра от 1 до %d) для просмотра информации о нем\n" +
                                   " Введите 0 для просмотра информации обо всех\n"                           +
                                   " 0 - выход");
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
        return null;
    }
}