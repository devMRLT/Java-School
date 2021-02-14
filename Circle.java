//package subclasses;
class Circle extends Shape{
	//create the radius
	float radius;
	public Circle(String color, float radius){
		super(color);
		this.radius = radius;
		//toString();
	}
	public float getArea(){//caculates the radius of the circle
		return (3.14f)*this.radius*this.radius;
	}
	public float getPerimeter(){//calculates the circumference of the circle
		return  2.0f*(3.14f)*this.radius;
	}

/*
	@Override
	public String toString() {
		return this.color + "Circle"+ this.radius;
	}
	*/
}