package swagger.training.swaggerDemo.model;

public class User {
    /** 编号 */
    private int id;
    /** 姓名 */
    private String name;
    /** 年龄 */
    private String number;

    public User(){
    }
    /**
     *  构造方法
     * @param id  编号
     * @param name  姓名
     */
    public User(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}


