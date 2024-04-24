public class BinoMialHeap {
    private heapNode head;

    public BinoMialHeap(heapNode head) {
        this.head = head;
    }

    public heapNode getHead() {

        return head;
    }

    public void setHead(heapNode head) {
        this.head = head;
    }

    public heapNode FindMax(){
        heapNode max=new heapNode(-1);
        heapNode h= head;
        while (h!=null){
            if(h.getKey()>max.getKey())
                max=h;
            h=h.getSibling();
        }
        return max;
    }

    private void linkednext(heapNode h1, heapNode h2){
        h1.setParent(h2);
        h1.setSibling(h2.getChild());
        h2.setChild(h1);
        h2.setDegree(h2.getDegree()+1);
    }
    private void Union(heapNode head2){
        merge(head2);
        heapNode prev= null;
        heapNode x= head;
        heapNode next= x.getSibling();
        while (next!= null){

            if( (x.getDegree()!= next.getDegree()) || (next.getSibling()!= null && next.getSibling().getDegree()==x.getDegree())){
                prev=x;
                x= next;

            }
            else{
                if(x.getKey()>next.getKey())
                {
                    x.setSibling(next.getSibling());
                    linkednext(next,x);

                }
                else {
                    if (prev==null){
                        setHead(next);


                    }
                    else {
                        prev.setSibling(next);
                    }
                    linkednext(x, next);
                    x=next;
                }
            }
            next=x.getSibling();
        }

    }
    public void Insert(int x){
        heapNode h=new heapNode(x);
        Union(h);
        System.out.println("Inserted "+ x);
    }

    private heapNode search(heapNode h, int key){
        heapNode found=null;
        while ( h!= null){
            if (h.getKey()==key){
                found=h;
                break;
            }
            if(h.getChild()== null){
                h= h.getSibling();
            }
            else {
                found=search(h.getChild(),key);
                if (found==null)
                    h= h.getSibling();
                else break;
            }

        }
return found;
    }
    private heapNode reverse(heapNode h){
        heapNode prev =null;
        heapNode x=h;
        heapNode next= h;
        while (next!= null){

            next= next.getSibling();
            x.setSibling(prev);
            prev=x;
            x=next;
        }
        h= prev;
        return h;
    }

    public void increaseKey( int oldK, int newK){
        if(oldK>newK)
            System.out.println("error");
        else {
            heapNode key= search(head,oldK);
            if (key==null)
            { System.out.println("not found");
                return;}
            key.setKey(newK);
            heapNode y= key;
            heapNode parent= y.getParent();
           do {
               System.out.println(y.getParent().getKey());
                int temp= y.getKey();
                y.setKey(parent.getKey());
                parent.setKey(temp);
                y=parent;
                parent=y.getParent();
            }
           while (parent!=null && y.getKey()> parent.getKey());
        }
        System.out.println("Increased "+oldK+".The updated value is "+newK);
    }
    public void ExtractMax(){
        heapNode max= FindMax();
        heapNode prev_max=null;
        heapNode curr=head;
        while (curr.getSibling()!= null){
            if (curr.getSibling().getKey()== max.getKey()){
                prev_max=curr;
                break;}
                curr=curr.getSibling();
        }
        if(head==max)
            head=max.getSibling();
        else {
        prev_max.setSibling(null);
        curr=reverse(max.getChild());
        Union(curr);}
        System.out.println("ExtractMax returned "+max.getKey());
    }

    private void merge(heapNode head2){
        heapNode temp1=head;
        heapNode temp2=head2;
        heapNode tempH=null;
        heapNode prev=null;
        while (temp1 != null && temp2 != null) {
            if (temp1.getDegree() <= temp2.getDegree()) {
                tempH = temp1;
                temp1 = temp1.getSibling();
            }
            else {
                tempH=temp2;
                temp2=temp2.getSibling();
            }
            if (prev==null){
                prev=tempH;
                head=tempH;
            }
            else {
                prev.setSibling(tempH);
                prev=tempH;
            }

        }

        if (temp1!=null)
            tempH.setSibling(temp1);
        else
            tempH.setSibling(temp2);
    }

    public void print(){
        //System.out.println(head.getKey());
        heapNode curr= head;
        while (curr!= null){
            System.out.println("Binomial Tree, B"+curr.getDegree());
            heapNode h=curr;
            System.out.print("level"+" "+0+":");
            System.out.println(h.getKey()+" ");
            for (int i = 1; i <= curr.getDegree(); i++) {
                System.out.print("level"+" "+i+":");
                heapNode temp=h.getChild();
                while (temp!=null){
                    System.out.print(temp.getKey()+" ");
                    temp=temp.getSibling();
                }
                System.out.println(" ");
                h=h.getChild();

            }
            curr=curr.getSibling();
        }
        System.out.println("-------------------------------------------");
    }

}

class heapNode{
    private int key;
    private int degree;
    private heapNode parent;
    private heapNode child;
    private heapNode sibling;

    public heapNode(int key) {
        this.key = key;
        this.degree = 0;
        this.parent = null;
        this.child = null;
        this.sibling = null;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public heapNode getParent() {
        return parent;
    }

    public void setParent(heapNode parent) {
        this.parent = parent;
    }

    public heapNode getChild() {
        return child;
    }

    public void setChild(heapNode child) {
        this.child = child;
    }

    public heapNode getSibling() {
        return sibling;
    }

    public void setSibling(heapNode sibling) {
        this.sibling = sibling;
    }
}