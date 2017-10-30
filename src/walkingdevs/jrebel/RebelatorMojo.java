package walkingdevs.jrebel;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Mojo(name = "do")
class RebelatorMojo extends AbstractMojo {
    public void execute() throws MojoExecutionException {
        if (!jrebelPath.exists() && !jrebelPath.mkdirs()) {
            throw new RuntimeException(
                "Cannot create directories"
            );
        }
        try (OutputStream stream = new FileOutputStream(jrebelPath.getAbsolutePath() + "/jrebel.prefs")) {
            stream.write(License.bytes());
            System.out.println(
                "Jrebel rebelated."
            );
        } catch (IOException e) {
            throw new RuntimeException(
                e
            );
        }
    }

    private File jrebelPath = new File(
        System.getProperty("user.home") + "/.jrebel"
    );
}