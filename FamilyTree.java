import java.util.ArrayList;
import java.util.Date;
/**
 * FamilyTree
 */
public class FamilyTree
{
    private String _familyName;
    private ArrayList<FamilyMemeber> _memebers;
    
    FamilyTree(String familyName)
    {
        _familyName = familyName;
        _memebers = new ArrayList<FamilyMemeber>();
    }

    public int Total()
    {
        return _memebers.size();
    }
    
    public FamilyMemeber FirstFamilyMemeber()
    {
        return _memebers.get(0);
    }

    public FamilyMemeber GetMemeberById(int memeberId)
    {
        return _memebers.get(memeberId);
    }
    
    public FamilyMemeber[] GetAllFamilyMemebers()
    {
        return _memebers.toArray(new FamilyMemeber[0]);
    }
    
    public FamilyMemeber AddChild(String name, String sex, Date birthDay, int parentId)
    {
        FamilyMemeber parent = parentId < _memebers.size() ? _memebers.get(parentId) : null;
        var child = new FamilyMemeber(_memebers.size(), name + " " + _familyName, sex, birthDay, parent);
        _memebers.add(child);
        return child;
    }

    public FamilyMemeber AddChild(String name, String sex, Date birthDay)
    {
        return AddChild(name, sex, birthDay, _memebers.size());
    }

    @Override
    public String toString()
    {
        var str = new StringBuilder();
        for (FamilyMemeber memeber : _memebers)
            str.append("\n" + memeber.toString());
        return str.toString();
    }
}