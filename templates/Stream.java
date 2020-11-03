
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

// Smaple: LinkedList 1 -> 0 -> 1 to 101(demical:5)
public int getDecimalValue(ListNode head) {
return Stream.iterate(head, i -> i != null, i -> i.next)
             .map(i -> i.val)
             .reduce(0, (a, b) ->  a * 2 + b);
}
