package com.example.flitapp.mvvm.models.repositories;

import java.util.ArrayList;
import java.util.HashMap;

public class TagRepository {
    private static TagRepository instance;

    private HashMap<String, String> tagsColors = new HashMap<>();
    private ArrayList<String> tagsList = new ArrayList<>();

    public TagRepository() {
        fillRepo();
    }

    public static TagRepository getInstance() {
        if (instance == null) {
            instance = new TagRepository();
        }
        return instance;
    }

    private void fillRepo() {
        tagsColors.put("html", "#e34c26");
        tagsColors.put("css", "#0057FF");
        tagsColors.put("javascript", "#f1e05a");
        tagsColors.put("assembly", "#6E4C13");
        tagsColors.put("delphi", "#EE5C67");
        tagsColors.put("c", "#555555");
        tagsColors.put("csharp", "#178600");
        tagsColors.put("cpp", "#f34b7d");
        tagsColors.put("clojure", "#db5855");
        tagsColors.put("dart", "#00B4AB");
        tagsColors.put("fortran", "#4d41b1");
        tagsColors.put("go", "#00ADD8");
        tagsColors.put("groovy", "#e69f56");
        tagsColors.put("haskell", "#5e5086");
        tagsColors.put("java", "#b07219");
        tagsColors.put("julia", "#a270ba");
        tagsColors.put("jupyter_notebook", "#DA5B0B");
        tagsColors.put("kotlin", "#F18E33");
        tagsColors.put("lua", "#000080");
        tagsColors.put("matlab", "#e16737");
        tagsColors.put("objectivec", "#197BE4");
        tagsColors.put("php", "#4F5D95");
        tagsColors.put("pascal", "#C9D65E");
        tagsColors.put("perl", "#0298c3");
        tagsColors.put("raku", "#0000fb");
        tagsColors.put("python", "#3572A5");
        tagsColors.put("r", "#198CE7");
        tagsColors.put("ruby", "#701516");
        tagsColors.put("rust", "#dea584");
        tagsColors.put("scala", "#c22d40");
        tagsColors.put("shell", "#89e051");
        tagsColors.put("smalltalk", "#596706");
        tagsColors.put("solidity", "#AA6746");
        tagsColors.put("swift", "#F88B4E");
        tagsColors.put("typescript", "#2b7489");
        tagsColors.put("vba", "#867db1");
        tagsColors.put("webassembly", "#04133b");
        tagsColors.put("onec", "#814CCC");
        tagsColors.put("ada", "#02f88c");
        tagsColors.put("asp_dotnet", "#9400ff");
        tagsColors.put("brainfuck", "#2F2530");
        tagsColors.put("csv", "#237346");
        tagsColors.put("glsl", "#5686a5");
        tagsColors.put("laravel", "#EB4432");
        tagsColors.put("react", "#5ED3F3");
        tagsColors.put("angular", "#DE0031");
        tagsColors.put("angularjs", "#CD0431");
        tagsColors.put("nodejs", "#68A063");
        tagsColors.put("vue", "#2c3e50");
        tagsColors.put("spring", "#54B236");
        tagsColors.put("django", "#092e20");
        tagsColors.put("ruby_on_rails", "#CC0000");
        tagsColors.put("gatsby", "#663399");
        tagsColors.put("ember", "#E24B31");
        tagsColors.put("mysql", "#00758F");
        tagsColors.put("postgresql", "#336791");
        tagsColors.put("microsoft_sql_server", "#858585");
        tagsColors.put("oracle_database", "#EF282B");
        tagsColors.put("sql", "#171717");
        tagsColors.put("mongodb", "#589636");
        tagsColors.put("redis", "#93161B");
        tagsColors.put("modx", "#16A02C");
        tagsColors.put("wordpress", "#21759B");
        tagsColors.put("bitrix", "#C00C2E");
        tagsColors.put("opencart", "#2EBFEB");
        tagsColors.put("tilda", "#1A1A1A");
        tagsColors.put("drupal", "#0073BA");
        tagsColors.put("dockerfile", "#384d54");
        tagsColors.put("git", "#F44D27");
        tagsColors.put("gradle", "#02303a");
        tagsColors.put("http", "#005C9C");
        tagsColors.put("svg", "#ff9900");
        tagsColors.put("flux", "#88ccff");

        tagsList.add("html");
        tagsList.add("css");
        tagsList.add("javascript");
        tagsList.add("assembly");
        tagsList.add("delphi");
        tagsList.add("c");
        tagsList.add("csharp");
        tagsList.add("cpp");
        tagsList.add("clojure");
        tagsList.add("dart");
        tagsList.add("fortran");
        tagsList.add("go");
        tagsList.add("groovy");
        tagsList.add("haskell");
        tagsList.add("java");
        tagsList.add("julia");
        tagsList.add("jupyter_notebook");
        tagsList.add("kotlin");
        tagsList.add("lua");
        tagsList.add("matlab");
        tagsList.add("objectivec");
        tagsList.add("php");
        tagsList.add("pascal");
        tagsList.add("perl");
        tagsList.add("raku");
        tagsList.add("python");
        tagsList.add("r");
        tagsList.add("ruby");
        tagsList.add("rust");
        tagsList.add("scala");
        tagsList.add("shell");
        tagsList.add("smalltalk");
        tagsList.add("solidity");
        tagsList.add("swift");
        tagsList.add("typescript");
        tagsList.add("vba");
        tagsList.add("webassembly");
        tagsList.add("onec");
        tagsList.add("ada");
        tagsList.add("asp_dotnet");
        tagsList.add("brainfuck");
        tagsList.add("csv");
        tagsList.add("glsl");
        tagsList.add("laravel");
        tagsList.add("react");
        tagsList.add("angular");
        tagsList.add("angularjs");
        tagsList.add("nodejs");
        tagsList.add("vue");
        tagsList.add("spring");
        tagsList.add("django");
        tagsList.add("ruby_on_rails");
        tagsList.add("gatsby");
        tagsList.add("ember");
        tagsList.add("mysql");
        tagsList.add("postgresql");
        tagsList.add("microsoft_sql_server");
        tagsList.add("oracle_database");
        tagsList.add("sql");
        tagsList.add("mongodb");
        tagsList.add("redis");
        tagsList.add("modx");
        tagsList.add("wordpress");
        tagsList.add("bitrix");
        tagsList.add("opencart");
        tagsList.add("tilda");
        tagsList.add("drupal");
        tagsList.add("dockerfile");
        tagsList.add("git");
        tagsList.add("gradle");
        tagsList.add("http");
        tagsList.add("svg");
        tagsList.add("flux");
    }

    public ArrayList<String> getTagsList() {
        return tagsList;
    }

    public HashMap<String, String> getTagsColors() {
        return tagsColors;
    }
}
