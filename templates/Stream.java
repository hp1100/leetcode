
        List<Catalog> list = new LinkedList<>();
        list.add(new Catalog("//cloudresourcemanager.googleapis.com/projects/1"));
        list.add(new Catalog("//cloudresourcemanager.googleapis.com/projects/2"));
        list.add(new Catalog("//cloudresourcemanager.googleapis.com/projects/3"));
        list.add(new Catalog("//cloudresourcemanager.googleapis.com/folders/1"));
        list.add(new Catalog("//cloudresourcemanager.googleapis.com/folders/2"));
        list.add(new Catalog("//cloudresourcemanager.googleapis.com/organization/1"));

        Map<String, Integer> map = list.stream()
                .map(Catalog::getResource)
                .map(str -> str.split("/", -1)[3])
                //.collect(Collectors.toMap(s -> s, s -> 1, Integer::sum));
                .collect(Collectors.groupingBy(s -> s, Collectors.summingInt(s -> 1)));
