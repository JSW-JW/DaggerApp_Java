# Flow to learn how to use Dagger in this app.

1. DaggerApplication > DaggerAppComponent(Application Level Component). Inject dependency from AppComponent(Server, Service) to Application(Client)
2. At the view level, activities and fragments will be acting as clients. And we have components acting as the services.(Client-Service)
3. In order to inject dependency into the activity or fragment, it has to be essentially marked as a potential client. (**link**)
4. Because of @BindsInstance in AppComponent(it binded application object), we can also use application object in AppModule. 
5. By default, viewModel Class has only empty constructor. So, it doesn't have any function inside of it by itself. To make it be able to survive from the configuration change, it needs to be created by viewModelProvider. For the same reason, if we wanna make a custom constructor viewmodel, we should be able to inform viewModelProvider any way to construct it. Thus, in this case, the viewmodel library is forcing us to use viewModelProvider.Factory interface.
6. Map multiBinding concepts(kind of mapping similar dependencies into a group, marking them with key, and inject them.)  


# Guide about flow of injection.
* Retrofit Instance & AuthApi Injection -> AppModule -> AppComponent -> AuthActivity(AuthActivitySubComponent) inside ActivitiyBuildersModule -> AuthModule, AuthViewModel


# Structure of Components

----------------------AppComponent(@Singleton)-----------------------
AuthComponent       /      MainComponent        /       AuthComponent
