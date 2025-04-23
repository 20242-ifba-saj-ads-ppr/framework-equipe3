package framework.vector;



// horizontal

// 0 1 2 3 4 5 6 7 8
// 1
// 2
// 3
// 4
// 5
// 6
// 7
// 8

public record Vector(
        int vertical,
        int horizontal
) {



    public boolean isSameHorizontal(Vector vector) {
        return this.horizontal == vector.horizontal;
    }

    public boolean isSameVertical(Vector vector) {
        return this.vertical == vector.vertical;
    }

    public Vector calculateDistance(Vector vector) {
        return new Vector(
                Math.abs(this.vertical - vector.vertical),
                Math.abs(this.horizontal - vector.horizontal)
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vector vector)) return false;

        if (vertical != vector.vertical) return false;
        return horizontal == vector.horizontal;
    }




}
