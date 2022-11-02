# MVVM (Model-View-ViewModel) Architecture Pattern in Android
1. Model — View — ViewModel (MVVM):
 - is the industry-recognized software architecture pattern that overcomes all drawbacks of MVP and MVC design patterns. 
 - MVVM suggests separating the data presentation logic(Views or UI) from the core business logic part of the application.

2. The separate code layers of MVVM are:
 - **Model**: This layer is responsible for the abstraction of the data sources. Model and ViewModel work together to get and save the data.
 - **View**: The purpose of this layer is to inform the ViewModel about the user’s action. This layer observes the ViewModel and does not contain any kind of application logic.
 - **ViewModel**: It exposes those data streams which are relevant to the View. Moreover, it serves as a link between the Model and the View.

3. Source code:
 - [Model-View-ViewModel using Kotlin](https://github.com/williamvietnam/android-architectures/tree/main/Model-View-ViewModel-Kotlin)
 - [Model-View-ViewModel using Java](https://github.com/williamvietnam/android-architectures/tree/main/Model-View-ViewModel-Java)

# MVP (Model-View-Presenter) Architecture Pattern in Android
1. Key Points of MVP Architecture:
 -  Communication between View-Presenter and Presenter-Model happens via an interface(also called Contract).
 - One Presenter class manages one View at a time i.e., there is a one-to-one relationship between Presenter and View.
 - Model and View class doesn’t have knowledge about each other’s existence.

2. MVP is widely accepted is that it provides modularity, testability, and a more clean and maintainable codebase. It is composed of the following three components:
 - **Model**: Layer for storing data. It is responsible for handling the domain logic(real-world business rules) and communication with the database and network layers.
 - **View**: UI(User Interface) layer. It provides the visualization of the data and keep a track of the user’s action in order to notify the Presenter.
 - **Presenter**: Fetch the data from the model and applies the UI logic to decide what to display. It manages the state of the View and takes actions according to the user’s input notification from the View.

3. Source code:
 - [Model-View-Presenter using Kotlin](https://github.com/williamvietnam/android-architectures/tree/main/Model-View-Presenter-Kotlin)
 - [Model-View-Presenter using Java](https://github.com/williamvietnam/android-architectures/tree/main/Model-View-Presenter-Java)
