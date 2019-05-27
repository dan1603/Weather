# Weather
This android application allows you to show weather forecast for different cities.

#### Demonstration

Video available <a href="https://drive.google.com/file/d/16SPkgD6lKwiKQ2iPHJAhfpeN7OJL-BNj/view?usp=sharing">here</a>.

#### Release

APK: <a href="https://drive.google.com/file/d/1oOfFGGCvQp3duCNihmZ-lt9hqf93hded/view?usp=sharing">Download</a>

#### Architecture
- Kotlin
- MVP
- Repository

#### Libraries
- Networking: Retrofit, OkHTTP
- DI: Dagger2
- Database: Room
- RxJava2
- Gson converter

#### Usecases

###### Splash Screen
- Load list of default cities
- Open Main Screen

###### Main Screen
- Get list of the cities from local Room database
- Add new city by name
- Remove city from local Room database
- Open Detail Screen of the city

###### Detail Screen
- Show formatted weather forecast of the city for next 5 days from OpenWeatherAPI
- Go back to Main Screen
