package com.example.repositorypatternwithhilt


import androidx.test.core.app.launchActivity
import com.example.repositorypatternwithhilt.di.AppModule
import com.example.repositorypatternwithhilt.ui.MainActivity
import com.example.repositorypatternwithhilt.ui.MainFragment
import com.example.repositorypatternwithhilt.ui.MainFragmentFactory
import com.example.repositorypatternwithhilt.util.launchFragmentInHiltContainer
import dagger.Module
import dagger.Provides
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsString
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@HiltAndroidTest
class MainTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var someString: String

    @Inject
    lateinit var fragmentFactory: MainFragmentFactory

    @Before
    fun init(){
        hiltRule.inject()
    }

    @Test
    fun someTest() {
        assertThat(someString, containsString("testing string"))
    }

    @Test
    fun mainActivityTest() {
        val scenario = launchActivity<MainActivity>()
    }

    @Test
    fun mainFragmentTest() {
        val scenario = launchFragmentInHiltContainer<MainFragment> (
            factory = fragmentFactory
                ) { }
    }

}

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [AppModule::class]
)
object TestAppModule {
    @Singleton
    @Provides
    fun provideSomeString(): String {
        return "It's some testing string!"
    }
}