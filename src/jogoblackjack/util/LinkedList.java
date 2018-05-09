package jogoblackjack.util;

public class LinkedList implements Ilist {

    private Node head;                    
    private Node tail;                      
    private int tamanho = 0;                    
                                                
    
    //Getters e setters dos atributos de "ListaEncadeada".
    private Node getHead() {
        return head;
    }    

    private void setHead(Node head) {
        this.head = head;
    }

    private Node getTail() {
        return tail;
    }

    private void setTail(Node tail) {
        this.tail = tail;
    }

    
    
    //Criação da subclasse "Celula".
    private class Node {
        private Node next;
        private Object data;
        private int posicao;

        public Node(Object data){ 
            this.data = data;
        }    

        //Getters e setters dos atributos de "Celula".                                
        public Object getData() {               
            return data;                        
        }                                           

        public void setData(Node data) {  
            this.data = data;               
        }                                          

        public Node getNext() {                
            return next;                         
        }                                          

        public void setNext(Node next) {    
            this.next = next;                 
        }   

        public int getPosicao() {
            return posicao;
        }

        public void setPosicao(int posicao) {
            this.posicao = posicao;
        }
    }  
        
    
    @Override
    public void addFirst(Object data) {
        
        Node nova = new Node(data); 
        nova.setNext(head.getNext());
        this.head = nova;                              
                                                                                                                     
        if(isEmpty()){                                   
            this.tail = this.head;                   
                                                           
        }                                                  
        this.tamanho++;         
    }
    
    @Override
    public void addLast(Object data) {
        
        if(isEmpty()){                       //primeiro verificamos se a lista está vazia. 
            addFirst(data);            //Se estiver, o método anterior é acionado.
        }
        else{
            Node nova = new Node(data); //Senão, a referência existente 
            nova.setNext(tail.getNext());
            this.tail.setNext(nova);             //em "última" e o tamanho da lista
            this.tail = nova;                       //são atualizados.
            this.tamanho++;
        }      
    } 
    
    @Override
    public Object removeFirst(Object data) {
        
        if(isEmpty()){                      //acontece a verificação do método "estaVazia".
            return null;
        }   
        Node aux = this.head;             //Se a lista não estiver vazia, 
        this.head = head.getNext();  //um auxiliar é utilizado para salvar
                                                //o conteúdo da célula que era a primeira.
                                                //"Primeira" é atualizada para a próxima célula.                                                
        this.tamanho--;                         //O tamanho da lista é atualizado 
        return aux.getData();     
    }
    
    @Override
    public Object removeLast(Object data) {
        
        Node anterior = this.head;    //utilizamos dois auxiliares: um para salvar
        Node auxTail = this.tail;     //a referência da célula anterior e outro  
                                            //para salvar a referência da última.
                                            
        if(isEmpty()){                    //Verificamos se a lista está vazia.
            return null;
        }
        else if(tamanho == 1){              //Verificamos se há apenas uma célula na lista.
            removeFirst(data);
        }
        else{           
            while(anterior.getNext() != auxTail){ //Se não, a lista é percorrida
                anterior = anterior.getNext();      //de forma que os auxiliares contenham
            }                                          //uma referência para a última célula e a anterior a ela.
            anterior.setNext(null);
            this.tail = anterior;                    //A célula anterior torna-se a última, 
                                                       //e a que era a última é desvinculada da lista.
            tamanho--;                                 //O tamanho da lista é atualizado e 
        }                                              //a célula removida é retornada.
        return auxTail.getData(); 
        
    }

    @Override
    public void set(int index, Object data) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Object get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean contains(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public int size() {
        return tamanho; 
    }

    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    @Override
    public boolean isEmpty() {
        return tamanho == 0; 
    }

}
