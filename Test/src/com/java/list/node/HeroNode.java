/**
 * 
 */
package com.java.list.node;

/**
 * @author PE
 * @date 2019年6月26日 下午5:34:27
 * @explain 
 */
public class HeroNode {
	public HeroNode leftNode;
    public HeroNode rightNode;
    public Hero h;
 
    public void insert(Hero g){
        if(h == null)
            h = g;
        else{
            if(h.hp <= g.hp ){
                if(leftNode == null)
                    leftNode = new HeroNode();
                leftNode.insert(g);
 
            }else{
                    if(rightNode == null)
                        rightNode = new HeroNode();
                    rightNode.insert(g);
 
                }
            }
        }
 
        public void inSearch(HeroNode root) {
            if(root.leftNode!=null)
                inSearch(root.leftNode);
            System.out.println(root.h);
            if(root.rightNode!=null)
                inSearch(root.rightNode);
        }
}
