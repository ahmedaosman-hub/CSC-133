package com.mycompany.a3;

public interface ICollider {

	boolean collidesWith(GameObject otherObjects);
	void handleCollision(GameObject otherObjects);
}
