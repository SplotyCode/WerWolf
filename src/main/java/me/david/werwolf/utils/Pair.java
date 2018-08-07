package me.david.werwolf.utils;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@EqualsAndHashCode
public class Pair<A, B> {

    @Getter @Setter private A a;
    @Getter @Setter private B b;

    public Pair builderSetA(A a) {
        setA(a);
        return this;
    }

    public Pair builderSetB(B a) {
        setB(b);
        return this;
    }

    public boolean contains(Object obj) {
        return a.equals(obj) || b.equals(obj);
    }


}
