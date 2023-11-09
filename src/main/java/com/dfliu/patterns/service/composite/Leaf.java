package com.dfliu.patterns.service.composite;

public class Leaf extends Component {
    public Leaf(String name) {
        super(name);
    }

    @Override
    public void add(Component v) {

    }

    @Override
    public void remove(Component v) {

    }

    /**
     * 按路径显示名称
     *
     * @param depth
     */
    @Override
    public void display(Integer depth) {
        for (int i = 0; i <= depth; i++) {
            System.out.print(">");
        }
        System.out.println(super.name);
    }
}
