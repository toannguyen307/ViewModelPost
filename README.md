# ViewModelPost
MVVM, ViewModel, DataBinding, Rx, Retrofit
# Mô hình MVVM

ViewModel

def lifecycle_version = "2.1.0"
implementation "android.arch.lifecycle:extensions:$lifecycle_version"
implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
implementation "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version"
kapt "androidx.lifecycle:lifecycle-compiler:$lifecycle_version"

Retrofit,RxJava

implementation 'com.squareup.retrofit2:retrofit:2.9.0'
implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
implementation 'com.squareup.retrofit2:adapter-rxjava2:2.2.0' 
implementation 'io.reactivex.rxjava2:rxjava:2.0.1'
implementation 'io.reactivex.rxjava2:rxandroid:2.0.1'

LiveData


 //DataBinding
    buildFeatures{
        dataBinding= true
    }
Navigation
   def nav_version = "2.2.2"
        classpath "androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version"
        
implementation 'androidx.navigation:navigation-fragment-ktx:2.2.2'
implementation 'androidx.navigation:navigation-ui-ktx:2.2.2'
