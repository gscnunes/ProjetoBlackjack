package jogoblackjack.util;

/**
 *
 * @author Daniel Alves e Gabriela dos Santos
 */
public interface IStack {

    /**
     * Método para adicionar um objeto na pilha
     *
     * @param data - objeto que irá ser adicionado
     */
    public void push(Object data);

    /**
     * Método para remover o último objeto adicionado da pilha
     *
     * @return objeto removido
     */
    public Object pop();

    /**
     * Método para mostrar o último objeto adicionado
     *
     * @return objeto que está na "cabeça" da pilha
     */
    public Object peek();

    /**
     * Método para saber se a pilha está vazia
     *
     * @return true caso a pilha esteja vazia
     */
    public boolean isEmpty();
}
