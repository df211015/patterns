package com.dfliu.patterns.service.composite;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component {

    private List<Component> child = new ArrayList<>();

    public Composite(String name) {
        super(name);
    }

    @Override
    public void add(Component v) {
        this.child.add(v);
    }

    @Override
    public void remove(Component v) {
        this.child.remove(v);
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
        for (Component item : this.child) {
            item.display(depth + 1);
        }
    }
}
