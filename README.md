# Flow to learn how to use Dagger in this app.

1. DaggerApplication > DaggerAppComponent(Application Level Component). Inject dependency from AppComponent(Server, Service) to Application(Client)
2. At the view level, activities and fragments will be acting as clients. And we have components acting as the services.(Client-Service)
3. In order to inject dependency into the activity or fragment, it has to be essentially marked as a potential client. (**link**)




# Structure of Components

----------------------AppComponent(@Singleton)-----------------------
AuthComponent       /      MainComponent        /       AuthComponent
