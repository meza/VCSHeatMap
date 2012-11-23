package hu.meza.vcsheatmap.connectors;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.treewalk.TreeWalk;

public class GitConnector {

    public List<Map<String, String>> browse(String pathname, int depth) throws IOException, GitAPIException {
        Git git = Git.open(new File(pathname));
        System.out.println(git.getRepository().getDirectory().getAbsolutePath());
        List<Map<String, String>> history = new ArrayList<Map<String, String>>();

        File workTree = git.getRepository().getWorkTree();


        Iterable<RevCommit> x;
        if (depth > 0) {
            x = git.log().setMaxCount(depth).call();
        } else {
            x = git.log().all().call();
        }
        for (RevCommit a : x) {
            TreeWalk tw = new TreeWalk(git.getRepository());

            tw.addTree(a.getTree());
            tw.setRecursive(true);
            Map<String, String> aa = new HashMap<String, String>();
            while (tw.next()) {
                aa.put(tw.getPathString(), a.getAuthorIdent().getName());
            }
            history.add(aa);

        }

        Collections.reverse(history);
        return history;

    }

}
