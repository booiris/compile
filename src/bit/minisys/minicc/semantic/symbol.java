package bit.minisys.minicc.semantic;

import java.util.ArrayList;
import java.util.List;

public class symbol {
    public String name, return_type, type;
    public List<Integer> value;
    public List<String> parm;
    public boolean is_return,is_define;

    public symbol(String return_type, String type) {
        value = new ArrayList<Integer>();
        parm = new ArrayList<String>();
        this.is_return = false;
        this.is_define = false;
        this.return_type = return_type;
        this.type = type;
    }
}
