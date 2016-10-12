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
    private String path = System.getProperty("user.home") + "/.jrebel";

    public void execute() throws MojoExecutionException {
        File f = new File(path);

        if (!f.exists()) {
            f.mkdirs();
        }

        try (OutputStream stream = new FileOutputStream(path + "/jrebel.prefs")) {
            stream.write(License.bytes());
            System.out.println("Jrebel rebelated.");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}