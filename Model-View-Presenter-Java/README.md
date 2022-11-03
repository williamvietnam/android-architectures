## MVP (Model-View-Presenter) Architecture Pattern in Android
1. Key Points of MVP Architecture:
 -  Communication between View-Presenter and Presenter-Model happens via an interface(also called Contract).
 - One Presenter class manages one View at a time i.e., there is a one-to-one relationship between Presenter and View.
 - Model and View class doesn’t have knowledge about each other’s existence.

<p align="center">
<img alt="MVVM" src="https://github.com/williamvietnam/android-architectures/blob/main/Model-View-Presenter-Kotlin/assets/mvp.png">
</p>

2. MVP is widely accepted is that it provides modularity, testability, and a more clean and maintainable codebase. It is composed of the following three components:
 - **Model**: Layer for storing data. It is responsible for handling the domain logic(real-world business rules) and communication with the database and network layers.
 - **View**: UI(User Interface) layer. It provides the visualization of the data and keep a track of the user’s action in order to notify the Presenter.
 - **Presenter**: Fetch the data from the model and applies the UI logic to decide what to display. It manages the state of the View and takes actions according to the user’s input notification from the View.
