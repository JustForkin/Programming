Michael Rubin   mnr2114  hw#4

A. I added a face shape and a tree shape.
B. In the SceneComponent class, I added: a mouseReleased action listener which switches the
state that the object was in originally as determined by a new boolean variable I added
and use on mousePressed.  Additionally, mouseDragged will now only translate an object if
s.contains(lastMousePoint) is true which means that only one shape at a time will be dragged
which is more natural feeling.
Basically, when you press down on a shape it saves whether it was selected or not in 
a variable, and then when you drag, it automatically pretends it wasn't so that when 
you release the button it marks it selected, as releasing switches the state which is what 
you want even when not dragging.
In sum: Now, you can only drag one item at a time (unless you choose to move over another 
selected item in which case it magnetizes and joins the drag) and also whether or not an 
object is selected, when you attempt to drag it it automatically will become selected and 
drag. This too is much more natural feeling.

The main method is still contained in the SceneEditor class.
The class diagram is in the  document with the theory questions.