package single;

/** @Author: 云萧YYY @DateTime: 2021/08/02 @Description: 模拟单链表结点， 一 */
public class HeroNode {

  /** 编号 */
  private int no;
  /** 姓名 */
  private String name;
  /** 别称 ，绰号 */
  private String nickName;
  /** 下一个结点 */
  public HeroNode next;

  public HeroNode(int no ,String name,String nickName){
      this.no=no;
      this.name=name;
      this.nickName=nickName;
  }
  @Override
  public String toString(){
      return "[no:"+no+",name:"+name+",nickName:"+nickName+"]";
  }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
