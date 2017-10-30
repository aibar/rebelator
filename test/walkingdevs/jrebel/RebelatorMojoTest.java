package walkingdevs.jrebel;

import org.apache.maven.plugin.MojoExecutionException;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class RebelatorMojoTest extends Assert {
    @Test
    public void shouldCrack() throws MojoExecutionException {
        new RebelatorMojo().execute();
        assertTrue(
            new File(
                System.getProperty("user.home") + "/.jrebel/jrebel.prefs"
            ).exists()
        );
    }
}